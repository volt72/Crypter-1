package de.bnd.crypter.implementations;

import java.util.function.BiFunction;
import java.util.function.Function;

import de.bnd.crypter.exceptions.CrypterException;

public class CrypterCaesar extends AbstractCrypter {

	public CrypterCaesar(String key) {
		super(key);
	}

	@Override
	public String encrypt(String message) throws CrypterException {
		return convertString(message, (c) -> (encryptChar(c)));
	}

	@Override
	public String decrypt(String cypherText) throws CrypterException {
		return convertString(cypherText, (c) -> (decryptChar(c)));
	}

	private char encryptChar(char x) {
		return convertChar(x, (val, k) -> (val + k));
	}

	private char decryptChar(char x) {
		return convertChar(x, (val, k) -> (val - k));
	}

	private char convertChar(char x, BiFunction<Integer, Integer, Integer> f) {
		int val = charToInt(x);
		int k = charToInt(getKey().charAt(0));
		int res = f.apply(val, k) < 0 ? 26 + f.apply(val, k) : f.apply(val, k) % 26;
		return intToChar(res);
	}

	private String convertString(String message, Function<Character, Character> f) throws CrypterException {

		StringBuilder s = new StringBuilder();

		for (int i = 0; i < message.length(); i++) {
			s.append(f.apply(message.charAt(i)));
		}

		return s.toString();

	}

	private char intToChar(int c) {
		return (char) (c + 'A');
	}

	private int charToInt(char c) {
		return c - 'A';
	}

}
