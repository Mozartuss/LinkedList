package list;

public class List {
  LinkElement head;

  public List() {
    head = null;
  }

  public void addFirst(String s) {
    LinkElement newElement = new LinkElement(s);
    newElement.next = head;
    head = newElement;
  }

  public void addLast(String s) {
    LinkElement newElement = new LinkElement(s);
    LinkElement temp = head;

    if (head.isEmpty())
      head = newElement;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newElement;
  }

  public void addTo(String s, int n) {
    LinkElement newElement = new LinkElement(s);
    if (n < 1) {
      addFirst(s);
      return;
    }
    if (n > length()) {
      addLast(s);
      return;
    }
    if (n > 1 && n <= length()) {
      LinkElement nthElement = findIndex(n);
      LinkElement preElement = findIndex(n - 1);
      preElement.next = newElement;
      newElement.next = nthElement;
    }
  }

  public String get(int n) {
    if (findIndex(n).isEmpty())
      return "";
    return findIndex(n).data;
  }

  public void reverse() {
    LinkElement runner = head;
    LinkElement newHead = null;

    while (runner != null) {
      LinkElement temp = runner;
      runner = runner.next;
      temp.next = newHead;
      newHead = temp;
    }
    head = newHead;
  }

  public int length() {
    int counter = 0;
    LinkElement iterator = head;
    while (iterator.hasNext()) {
      iterator = iterator.next;
      counter++;
    }
    return counter;
  }

  public void remove(int n) {
    if (n < 1) {
      head = head.next;
    } else {
      LinkElement nthElement = findIndex(n);
      if (nthElement.isEmpty())
        return;
      LinkElement preElemnt = findIndex(n - 1);
      preElemnt.next = nthElement.next;
    }
  }

  public void removeAll() {
    LinkElement temp;
    while (head.hasNext()) {
      temp = head.next;
      head = null;
      head = temp;
    }
    if (! head.isEmpty())
      head = null;
  }

  public String[] toArray() {
    String[] array = new String[length() + 1];
    LinkElement iterator = head;
    for (int i = 0; i <= length(); i++) {
      array[i] = iterator.data;
      iterator = iterator.next;
    }
    return array;
  }

  private LinkElement findIndex(int n) {

    if (n < 0)
      return null;

    LinkElement iterator = head;

    for (int i = 0; i < n; i++) {
      if (iterator.hasNext())
        iterator = iterator.next;
      else return null;

    }
    return iterator;
  }

  public String toString() {
    String s = "";
    if (head == null)
      return null;
    LinkElement helper = head;
    while (helper != null) {
      s += helper.data + " ";
      helper = helper.next;
    }
    return s;
  }
}
