package com.example.demo.Repository;
//
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//import javax.persistence.EntityManager;
//
//public class ScoreRecordRepositoryFactory {
//
//    private final EntityManager entityManager;
//
//    public ScoreRecordRepositoryFactory(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    public ScoreRecordRepository createScoreRecordRepository(String databaseName) {
//        // 切换到用户的数据库
//        entityManager.setProperty("javax.persistence.nonJtaDataSource", databaseName);
//
//        // 创建一个新的ScoreRecordRepository实例
//        return new SimpleJpaRepository<>(ScoreRecord.class, entityManager);
//    }
//}