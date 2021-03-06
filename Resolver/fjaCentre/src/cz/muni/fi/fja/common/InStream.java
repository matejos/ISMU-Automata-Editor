/*
 * InStream.java
 *
 * Created on 15. ��jen 2007, 16:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cz.muni.fi.fja.common;

public interface InStream {
  static int EOF = -1;

  // boolean isWhiteSpaceNoNewLine();
  // boolean isNewLine();

  boolean isEOF();

  boolean skipAllWhiteSpaces();

  boolean consume();

  boolean getExpectedSymbol(char c);

  boolean getExpectedSymbol(char[] d);

  boolean getSymbol();

  boolean getControl();

  boolean getAlphabet();

  String getLastSymbol();

  boolean anyLastSymbol();

  boolean lastSymbolIsControl();

  boolean isSpecialMark();

  boolean isFollowingSpecialMark();

  boolean isControlChar();

  char getChar();

  int getLine();

  int getPositionInLine();

  ModelError getError();

  boolean isError();

  void info();
}
