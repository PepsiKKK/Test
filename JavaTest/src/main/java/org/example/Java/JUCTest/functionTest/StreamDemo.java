package org.example.Java.JUCTest.functionTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        demo02();
    }

    public static void demo01() {
        // https://blog.csdn.net/mu_wind/article/details/109516995?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522171629120616800197061824%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=171629120616800197061824&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~blog~top_positive~default-2-109516995-null-null.nonecase&utm_term=stream&spm=1018.2226.3001.4450

        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int[] arr = new int[]{1, 2, 3, 4};

        Stream<Integer> stream1 = list.stream();
        IntStream stream2 = Arrays.stream(arr);
        Stream<Integer> stream3 = Stream.of(1, 2, 3);
        Stream<Integer> stream4 = Stream.iterate(1, (a) -> a + 2).limit(3);
        Stream<Double> stream5 = Stream.generate(Math::random).limit(3);

    }

    /**
     * 找出同时满足以下条件的用户
     * 1、全部满足偶数ID
     * 2、年龄大于24
     * 3、用户名转为大写
     * 4、用户名字母倒序
     * 5、只输出一个用用户名字 limit
     */
    public static void demo02() {
        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        list.stream()
                .filter(user -> {return user.getId() % 2 == 0;})
                .filter(user -> {return user.getAge() > 24;})
                .map(user -> {return user.getName().toUpperCase();})
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .forEach(System.out::println);

    }
}

class User {
    Integer id;
    String name;
    Integer age;
    public User() {
    }

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
