package dev.sandbox.repository;

import dev.sandbox.entity.TestEntity;
import dev.sandbox.entity.TestEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Integer> {

    TestEntity findByTestEnum(TestEnum testEnum);

}
