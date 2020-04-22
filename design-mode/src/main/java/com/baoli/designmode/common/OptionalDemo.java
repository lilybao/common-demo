package com.baoli.designmode.common;

import lombok.Data;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * @program: common-demo
 * @description:
 * @author: li baojian
 * @create: 2020-04-21 11:14
 */
public class OptionalDemo {

    @Test
    public void test() {
        User user1 = new User();
//        String name = user1.getAddress().getCountry().getName();
        Optional<User> user = getUser();
        String s = user.flatMap(User::getAddress).flatMap(Address::getCountry).map(Country::getName).orElse("123");
        assertTrue(user.isPresent());
//        System.out.println(user.isPresent());
        if (user.isPresent()) {
            System.out.println(user.get());
        }

    }

    private void assertTrue(boolean present) {
        Assert.assertTrue(present);
    }

    @Test
    public void test1() {
        Optional<User> user = Optional.empty();
        user.orElse(null);
        User user1 = user.get();
    }

    private Optional<User> getUser() {
        User user = new User();
        user.setName("lisi");
        Address address = new Address();
        address.setName("郑州");
        Country country = new Country();
        country.setName("中国");
        address.setCountry(country);
        user.setAddress(address);
        Optional.of(user);
        return Optional.ofNullable(user);
//        return Optional.of(user);
    }

    @Data
    class User {
        private String name;
        private int age;
        private Address address;

        public Optional<Address> getAddress() {
            return Optional.ofNullable(address);
        }
    }

    @Data
    class Address {
        private String name;
        private Country country;

        public Optional<Country> getCountry() {
            return Optional.ofNullable(country);
        }
    }

    @Data
    class Country {
        private String name;
        private String code;
    }
}
