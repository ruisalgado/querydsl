package com.querydsl.sql;

import org.junit.Test;

import com.querydsl.core.types.dsl.Coalesce;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CoalesceTest {

    @Test
    public void coalesce_supports_subquery() {
        Coalesce<String> coalesce =
                new Coalesce<String>(SQLExpressions.select(QCompanies.companies.name).from(QCompanies.companies), QCompanies.companies.name);
        assertThat(SQLExpressions.select(coalesce).toString(),
                is(equalTo("select coalesce((select COMPANIES.NAME\nfrom COMPANIES COMPANIES), COMPANIES.NAME)\nfrom dual")));
    }

}
