package cr.session.impl;

import cr.session.Session;
import cr.session.SessionFactory;
import cr.session.security.SessionCredentials;
import cr.session.security.impl.PermissionChecker;

public class SessionFactoryImpl implements SessionFactory
{
	@Override
	public Session createSession(final SessionCredentials credentials)
	{
		final PermissionChecker checker = new PermissionChecker(credentials);
		
		// Проверка возможности создания сессии
		checker.createSession();
		
		final SessionContext currentContext = SessionContextManager.getStorageManager().getContext();
		final SessionContext contextOfSession = (
				checker.isReadonly() ?
						currentContext :
						currentContext.cloneWithIncrementedRevision(checker));
		
		final Session newSession = new SessionImpl(contextOfSession);
		return newSession;
	}
}
