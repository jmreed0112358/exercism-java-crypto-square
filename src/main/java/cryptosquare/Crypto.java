package cryptosquare;

import java.util.ArrayList;
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
		
		// Generate all state.
		this.generateNormalizedPlaintext( rawInput );
		this.computeSquareSize( );
		this.generatePlaintextSegments( );
		this.cipherText = this.generateCiphertext( false );
		this.normalizedCipherText = this.generateCiphertext( true );
	}
	
	// Public getters.
	
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
		return this.normalizedCipherText;
	}
	
	// Private state generation functions.
	
	private void generateNormalizedPlaintext(String rawInput) {
		if ( rawInput.isEmpty( ) ) {
			this.normalizedPlaintext = rawInput;
		}
		
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < rawInput.length( ) ; i++ ) {
			if ( Character.isLetterOrDigit( rawInput.charAt( i ) ) ) {
				sb.append( rawInput.charAt( i ) );
			}
		}
		
		this.normalizedPlaintext = sb.toString( ).toLowerCase( );
	}
	
	private void computeSquareSize() {
		Integer inputLength = this.normalizedPlaintext.length( );
		this.squareSize = (int) Math.ceil( Math.sqrt( inputLength.doubleValue( ) ) );
	}
	
	private void generatePlaintextSegments( ) {
		this.plaintextSegments = new ArrayList<String>();
		
		// http://stackoverflow.com/questions/9276639/java-how-to-split-a-string-by-a-number-of-characters
		// Credit: Guillaume Polet.
		int index = 0;
		while ( index < this.normalizedPlaintext.length( ) ) {
			this.plaintextSegments.add(  this.normalizedPlaintext.substring( index, Math.min( index + this.squareSize, this.normalizedPlaintext.length( ) ) ) );
			index += this.squareSize;
		}
	}
	
	private String generateCiphertext( boolean normalized ) {
		StringBuilder sb = new StringBuilder();
		
		for ( int i = 0 ; i < this.squareSize ; i++ ) {
			for ( int j = 0 ; j < this.plaintextSegments.size( ) ; j++ ) {
				if ( i < this.plaintextSegments.get( j ).length( ) ) {
					sb.append( this.plaintextSegments.get( j ).charAt( i ) );
				}
			}
			
			if ( normalized && i != this.squareSize - 1) {
				sb.append( ' ' );
			}
		}
		
		return sb.toString( );
	}
}
