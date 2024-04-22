module com.inditex.pricing.infrastructure {
    requires com.inditex.pricing.domain;
    requires com.inditex.pricing.application;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.data.jpa;
    requires spring.context;
    requires jakarta.persistence;
    requires lombok;
    requires spring.data.commons;
    requires org.mapstruct;
    requires spring.web;
    requires org.apache.tomcat.embed.core;
    requires io.swagger.v3.oas.annotations;
    requires io.swagger.v3.oas.models;
    requires com.fasterxml.jackson.databind;
    requires io.swagger.v3.core;

    exports com.inditex.pricing.infrastructure.adapter.database.entity;
    exports com.inditex.pricing.infrastructure.adapter.database.mapper;
    exports com.inditex.pricing.infrastructure.adapter.database.repository;
    exports com.inditex.pricing.infrastructure.adapter.database.repository.h2;
    exports com.inditex.pricing.infrastructure.rest.api;
    exports com.inditex.pricing.infrastructure.rest.api.config;
    exports com.inditex.pricing.infrastructure.rest.api.mapper;
    exports com.inditex.pricing.infrastructure.rest.api.populator;
    exports com.inditex.pricing.infrastructure.rest.api.responses;
    exports com.inditex.pricing.infrastructure.rest.api.spec;
    exports com.inditex.pricing.infrastructure.rest.api.spec.config;
    exports com.inditex.pricing.infrastructure.rest.api.spec.schema;
}
