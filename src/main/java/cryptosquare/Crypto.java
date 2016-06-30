package cryptosquare;

import java.util.List;

import exceptions.NotImplementedException;

public class Crypto
{
	private String normalizedPlaintext;
	private Integer squareSize;
	private List<String> plaintextSegments;
	private String cipherText;
	private String normalizedCipherText;
	
	public Crypto( String rawInput ) {
		if ( rawInput == null ) {
			throw new NullPointerException();
		}
	}
	
	public String getNormalizedPlaintext() {
		return this.normalizedPlaintext;
	}
	
	public Integer getSquareSize() {
		return this.squareSize;
	}
	
	public List<String> getPlaintextSegments() {
		return this.plaintextSegments;
	}
	
	public String getCipherText() {
		return this.cipherText;
	}
	
	public String getNormalizedCipherText() {
		return normalizedCipherText;
	}
	
	private void generateNormalizedPlaintext(String rawInput) {
		throw new NotImplementedException();
	}
	
	private void computeSquareSize() {
		throw new NotImplementedException();
	}
	
	private void generatePlaintextSegments( ) {
		throw new NotImplementedException();
	}
	
	private void generateCiphertext( boolean normalized ) {
		throw new NotImplementedException();
	}
}
