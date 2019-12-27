package com.baoli.test.designmode;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * @description: Stream流的使用
 * @author: li baojian
 * @create: 2019/09/23 09:19
 */
public class StreamTest {

    @Test
    public void concatTest(){
        Stream.concat(Stream.of(1,2,3,4),Stream.of(5,6,7,8)).forEach(integer -> System.out.println(integer));
    }
    @Test
    public void distinctTest(){
     Stream.of(1,2,3,4,4,3,2).distinct().forEach(integer -> System.out.println(integer));
    }
    @Test
    public void filterTest(){
        Stream.of(1,2,3,4,4,3,2).filter(integer -> integer>=3).forEach(integer -> System.out.println(integer));
    }
    @Test
    public void mapTest(){
        Stream.of(1,2,3,4,4,3,2).mapToDouble(Integer::intValue).forEach(integer -> System.out.println(integer));
    }
    @Test
    public void flatMapTest(){
        Stream.of(1,2,3,4,4,3,2).flatMap(integer -> Stream.of(integer*100)).forEach(integer -> System.out.println(integer));
    }
    @Test
    public void peekTest(){
        Stream.of(1,2,3,4,4,3,2).peek(integer -> System.out.println("accept"+integer)).forEach(System.out::println);
    }

}
