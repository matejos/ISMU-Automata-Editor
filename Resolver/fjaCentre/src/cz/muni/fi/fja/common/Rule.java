package cz.muni.fi.fja.common;

import java.util.Set;

public interface Rule {
  boolean add(Alphabet a);

  boolean add(Alphabet a, Control c);

  boolean add(Alphabet a, Rule r);

  Set<Alphabet> getAlphabet();

  Control[] getControl(Alphabet a);

  Control getControl();

  Rule convertToNFA(Control c);

  void setTested();

  boolean isTested();

  boolean containsEpsilon();

  boolean containsAlphabet();

  boolean containsControl();

}
