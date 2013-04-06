package cr.session.security.impl;


public class SessionReadOnlyCredentials extends SessionCredentialsBaseImpl
{

	@Override
	public boolean canChange()
	{
		return false;
	}

}
