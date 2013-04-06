package cr.session.security.impl;

import cr.session.security.SessionCredentials;

public abstract class SessionCredentialsBaseImpl implements SessionCredentials
{
	abstract public boolean canChange();
}
