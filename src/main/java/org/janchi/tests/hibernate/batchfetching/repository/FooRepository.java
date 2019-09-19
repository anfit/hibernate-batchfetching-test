package org.janchi.tests.hibernate.batchfetching.repository;

import javax.transaction.Transactional;

import org.janchi.tests.hibernate.batchfetching.entity.unenhanced.UnenhancedFoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface FooRepository extends JpaRepository<UnenhancedFoo, Long> {
}
