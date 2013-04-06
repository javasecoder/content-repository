package cr.session.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cr.session.Session;


// ����� ��� ���������� ����������� ������
public class SessionContextManager
{
	// ������ ������� ����������
	static private final Map<Long, RevisionData> revisions = new HashMap<Long, RevisionData>();
	// ��������� ������
	static private final StorageManager storageManager = new StorageManager();
	
	
	
	
	synchronized static public void registerSession(final SessionImpl newSession)
	{
		final SessionContext context = newSession.getContext();
		final long revision = context.getRevision();
		
		RevisionData revisionData = revisions.get(revision);
		if (revisionData == null)
		{
			revisionData = new RevisionData(revision, context);
			revisions.put(revision, revisionData);
		}
		
		revisionData.bind(newSession);
	}
	
	synchronized static public void removeSession(final SessionImpl session)
	{
		final SessionContext context = session.getContext();
		final long revision = context.getRevision();
		
		final RevisionData revisionData = revisions.get(revision);
		if (revisionData == null) return;
		
		revisionData.unbind(session);
		if (revisionData.isEmpty())
		{
			revisions.remove(revision);
		}
	}
	
	
	static public StorageManager getStorageManager()
	{
		return storageManager;
	}
	
	
	
	// ������, ��������� � ������� ��������
	@SuppressWarnings("unused")
	static private class RevisionData
	{
		// ����� �������
		public final long revision;
		// ��������
		public final SessionContext context;
		// ��������� ������
		public final Set<Session> boundSessions = new HashSet<Session>();
		
		
		public RevisionData(final long revision, final SessionContext context)
		{
			this.revision = revision;
			this.context = context;
		}
		
		public void bind(final Session session)
		{
			this.boundSessions.add(session);
		}
		
		public void unbind(final Session session)
		{
			this.boundSessions.remove(session);
		}
		
		public boolean isEmpty()
		{
			return this.boundSessions.isEmpty();
		}
	}
}
