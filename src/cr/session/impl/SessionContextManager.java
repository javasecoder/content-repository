package cr.session.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import cr.session.Session;


// Класс для управления контекстами сессий
public class SessionContextManager
{
	// Список текущих контекстов
	static private final Map<Long, RevisionData> revisions = new HashMap<Long, RevisionData>();
	// Хранилище данных
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
	
	
	
	// Данные, связанные с текущей ревизией
	@SuppressWarnings("unused")
	static private class RevisionData
	{
		// Номер ревизии
		public final long revision;
		// Контекст
		public final SessionContext context;
		// Связанные сессии
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
