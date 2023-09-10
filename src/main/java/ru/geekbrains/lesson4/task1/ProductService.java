package ru.geekbrains.lesson4.task1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ProductService implements Readable {

    private ArrayList<String> res;
    public void process1(){
    }

    public void process2(){
        res = null;
    }

    /**
     * Считывание и обработка данных
     * @param file файл
     * @return коллекция данных
     * @throws RuntimeException исключение при обработке файла
     */
    public Collection<String> readTextFile(File file) throws RuntimeException{

        // ПРЕДУСЛОВИЕ
        if (file.exists()) {
            if (file.length() > 5000)
                throw new RuntimeException("Размер файла более 5мб. Чтение файла запрещено.");
        }
        else {
            throw new RuntimeException("Файл не найден.");
        }

        //region РАБОТА С ДАННЫМИ

        res = new ArrayList<>();
        res.add("AAAAA");
        res.add("BBBBB");


        process1();

        // ИНВАРИАНТ
        validateResult(res);

        process2();

        // ИНВАРИАНТ
        validateResult(res);

        //endregion

        // ПОСТУСЛОВИЕ

        if (res == null) {
            throw new RuntimeException("Ошибка обработки данных.");
        }

        //TODO: Возвращаем результат выполнения задачи ...
        return res;
    }

    private void validateResult(Collection<String> res){
        if (res == null || res.size() == 0){
            throw new RuntimeException("Некорректное состояние объекта");
        }
    }

}

/**
 * Позволяет считывать данные
 */
interface Readable{

    /**
     * Считывание и обработка данных
     * @param file файл
     * @return коллекция данных
     * @throws RuntimeException исключение при обработке файла
     */
    Collection<String> readTextFile(File file) throws RuntimeException;
}




















