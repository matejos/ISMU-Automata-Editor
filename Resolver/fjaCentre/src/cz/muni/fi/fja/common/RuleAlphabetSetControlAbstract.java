package cz.muni.fi.fja.common;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public abstract class RuleAlphabetSetControlAbstract extends RuleAbstract {
  protected Map<Alphabet, Set<Control>> right;

  public RuleAlphabetSetControlAbstract(Control c) {
    /** Creates a new instance of RuleAlphabetSetControlAbstract */
    super(c);
    right = new HashMap<Alphabet, Set<Control>>();
  }

  public Set<Alphabet> getAlphabet() {
    return right.keySet();
  }

  public Control[] getControl(Alphabet a) {
    return right.get(a).toArray(new Control[0]);
  }

  protected boolean addRule(Alphabet a, Control c) {
    Set<Control> s = (Set<Control>) right.get(a);
    if (s == null) {
      s = new HashSet<Control>();
      right.put(a, s);
    }
    return s.add(c);
  }

  protected void setTestedAbstract() {
    for (Alphabet a : right.keySet())
      a.setInt(1);
    for (Set<Control> s : right.values())
      for (Control c : s) {
        if (c.getRule() != null) {
          c.getRule().setTested();
        }
      }
  }

  public Rule convertToNFA(Control c) { // c je koncovy stav - tzn vsechny
                                        // terminaly, bez prechodu do dalsiho
                                        // stavu tam budou ukonceny
    Alphabet eps = null;
    if (containsAlphabet()) {
      for (Alphabet a : right.keySet()) {
        if (a.isEpsilon()) {
          eps = a;
        }
        Set<Control> s = right.get(a);
        if (s.contains(Control.getNullControl())) {
          s.remove(Control.getNullControl());
          s.add(c);
        }
      }
    }
    if (containsEpsilon()) {
      right.remove(eps);
    }
    return this;
  }

}
