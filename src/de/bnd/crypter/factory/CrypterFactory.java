/**
 * 
 */
package de.bnd.crypter.factory;

import de.bnd.crypter.factory.exceptions.CrypterException;
import de.bnd.crypter.factory.exceptions.IllegalKeyException;
import de.bnd.crypter.factory.interfaces.Crypter;

/**
 * @author user
 *
 */
public class CrypterFactory {

	/**
	 * Crypter types
	 */
	public enum CrypterType {
		CAESAR, SUBSTITUTION, REVERSE, XOR, NULL
	}

	public static Crypter createCrypter(CrypterType type, String key) throws CrypterException, IllegalKeyException {

		switch (type) {
		case CAESAR:
			return new CrypterCaesar(key);
		case SUBSTITUTION:
			return new CrypterSubstitution(key);
		case REVERSE:
			return new CrypterReverse();
		case XOR:
			return new CrypterXOR(key);
		case NULL:
			return new CrypterNull();
		default:
			throw new CrypterException();
		}

	}

}
