package cr.session;

import cr.session.security.SessionCredentials;

public interface SessionFactory
{
	Session createSession(final SessionCredentials credentials);
}
