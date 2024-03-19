package com.texoit.desafio.factory;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.texoit.desafio.domain.Address;
import com.texoit.desafio.domain.Company;
import com.texoit.desafio.domain.Geo;
import com.texoit.desafio.domain.User;

public class UserDataFactory {

    public static User newUser(){
        Faker faker = new Faker();

        Geo geo = Geo.builder().
                lat("-37.3159").
                lng("81.1496").
                build();

        com.github.javafaker.Address address = faker.address();

        Address addressBody = Address.builder().
                street(address.streetAddress()).
                suite(address.streetAddressNumber()).
                city(address.city()).
                zipcode(address.zipCode()).
                geo(geo)
                .build();

        Name name = faker.name();
        com.github.javafaker.Company company = faker.company();
        Company companyBody = Company.builder().
                name(company.name()).
                catchPhrase(company.catchPhrase()).
                bs(company.bs()).
                build();

        return User.builder().
                name(name.name()).
                username(name.username()).
                email(name.username().concat("mock.com")).
                address(addressBody).
                phone(faker.phoneNumber().phoneNumber()).
                website(faker.internet().domainName()).
                company(companyBody).
                build();
    }
}
