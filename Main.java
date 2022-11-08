class Main {}

class Student { // Context
  State wakeUp = new WakeUp(this);
  State dizzy = new Dizzy(this);
  State excited = new Excited(this);
  State current = wakeUp;
  State getState() { return current; }
  void setState(State s) { current = s; }
  State getDizzy() { return dizzy; }
  State getExcited() { return excited; }

  void drinkMilk() { current.milk(); System.out.println(current); }
  void drinkCoffee() { current.coffee(); System.out.println(current); }
}

interface State { public void milk(); public void coffee(); }

class WakeUp implements State {
  Student s;
  WakeUp(Student t) { s = t; }
  public void milk() {
    s.setState(s.getDizzy()); 
  }

  public void coffee() { s.setState(s.getExcited()); }
  public String toString() { return "WakeUp"; }
}

class Dizzy implements State {
  Student s;
  Dizzy(Student t) { s = t; }
  public void milk() { s.setState(s.getDizzy()); }
  public void coffee() { s.setState(s.getDizzy()); }
  public String toString() { return "Dizzy"; }
}

class Excited implements State {
  Student s;
  Excited(Student t) { s = t; }
  public void milk() { s.setState(s.getExcited()); }
  public void coffee() { s.setState(s.getExcited()); }
  public String toString() { return "Excited"; }
}