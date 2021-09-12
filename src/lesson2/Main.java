package lesson2;

public class Main {
    public static void main(String[] args) {
        int total =0;
        String[][] arr = new String[][]{{"5", "5", "5", "5"}, {"6", "6", "6", "6", "6"}, {"7", "семь", "7", "7"}, {"8", "8", "8", "8"}};
       //Если в массиве всё введено корректно
        try {
            total = 0;
            total = method(arr);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Сумма массива равна" + " " + String.valueOf(total));
        }
        //Если в массиве введены данные некорректно
        try {
            total = 0;
            total = method(arr);
        } catch (MyArraySizeException e) {
            System.out.println("Нарушен размер массива!");
        } catch (MyArrayDataException e) {
            System.out.println("Некорректно введены данные!");
            System.out.println("Поменяйте данные в массиве, ячейка " + e.x + "." + e.y);
        } finally {
            System.out.println("Сумма массива равна" + " " + String.valueOf(total));
        }
    }

    public static int method(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int x = 0; x < arr.length; x++) {
            if (arr[x].length != 4) {
                throw new MyArraySizeException();
            }
            for (int y = 0; y < arr.length; y++) {
                try {
                    count = count + Integer.parseInt(arr[x][y]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(x, y);
                }
            }
        }
        return count;
    }
}
