package list;

class LinkElement {
  String data;
  LinkElement next;

  LinkElement(String data) {
    this.data = data;
    this.next = null;
  }

  boolean isEmpty() {
    return this == null;
  }

  boolean hasNext() {
    return this.next != null;
  }
}
