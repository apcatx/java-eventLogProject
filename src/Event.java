public class Event {

  private String name;
  private String action;


  String getName() {
    return name;
  }

  void setName(String name) {
    this.name = name;
  }

  String getAction() {
    return action;
  }

  void setAction(String action) {
    this.action = action;
  }

  @Override
  public String toString() {
    return "\tEvent\n" +
            "\t--------------------------\n" +
            "\tName - '" + name + "'\n" +
            "\tAction - '" + action + "'\n\n";
  }
}