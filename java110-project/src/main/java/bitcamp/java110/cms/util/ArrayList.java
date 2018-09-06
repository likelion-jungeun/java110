package bitcamp.java110.cms.util;

public class ArrayList<T> implements List<T> {// 제네릭

    private Object[] list = new Object[5];
    private int index = 0;

    public void add(T obj) {

        if (index == list.length) {
            increaseStorage();
        }
        list[index++] = obj;

    }

    private void increaseStorage() {
        Object[] newList = new Object[list.length + 3];
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }

    public T remove(int no) {

        if (no < 0 || no >= index) {
            return null;
        }
        @SuppressWarnings("unchecked")
        T removedObj = (T) list[no];

        for (int i = no; i < index - 1; i++) {
            list[i] = list[i + 1];
        }
        index--;

        return removedObj;
    }

    public int size() {
        return index;
        // this가 생략되어 있음!-> this값은 내가 size를 호출할 때 어떤 인스턴스 값을 넣느냐에 따라 바뀜
    }

    @SuppressWarnings("unchecked")
    public T get(int no) {
        if (no < 0 || no >= index) {
            return null;
        }
        return (T) list[no]; // 얘가 경고해서 위에 SuppressWarnings써서 경고 없앰
    }
}
