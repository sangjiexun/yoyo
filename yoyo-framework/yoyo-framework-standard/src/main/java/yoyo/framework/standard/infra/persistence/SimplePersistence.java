// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.standard.infra.persistence;
import java.io.Serializable;
import java.util.Map;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.LockTimeoutException;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceException;
import javax.persistence.PessimisticLockException;
import javax.persistence.TransactionRequiredException;
import javax.persistence.metamodel.Metamodel;
/**
 * データ永続化の基本操作I/F
 * @param <T> エンティティオブジェクト型
 * @author nilcy
 */
public interface SimplePersistence<T extends Serializable> {
    /**
     * 永続化
     * <dl>
     * <dt>事前条件</dt>
     * <dd>throws項を参照すること。</dd>
     * <dt>事後条件</dt>
     * <dd>新しいエンティティを管理エンティティにすること。</dd>
     * </dl>
     * @param entity 新しいエンティティ
     * @throws EntityExistsException 登録済のエンティティがあるとき
     * @throws IllegalArgumentException エンティティでないとき
     * @throws TransactionRequiredException トランザクションが存在しないとき
     * @see EntityManager#persist(Object)
     */
    void persist(T entity);
    /**
     * 再結合
     * <dl>
     * <dt>事前条件</dt>
     * <dd>throws項を参照すること。</dd>
     * <dt>事後条件</dt>
     * <dd>分離エンティティを管理エンティティにすること。</dd>
     * </dl>
     * @param entity 分離エンティティ
     * @return 管理エンティティ
     * @throws IllegalArgumentException エンティティでないとき
     * @throws TransactionRequiredException トランザクションが存在しないとき
     * @see EntityManager#merge(Object)
     */
    T merge(T entity);
    /**
     * 削除
     * <dl>
     * <dt>事前条件</dt>
     * <dd>throws項を参照すること。</dd>
     * <dt>事後条件</dt>
     * <dd>管理エンティティを削除エンティティにすること。</dd>
     * </dl>
     * @param entity 管理エンティティ
     * @throws IllegalArgumentException エンティティオブジェクト型でない、または分離エンティティのとき
     * @throws TransactionRequiredException トランザクションが存在しないとき
     * @see EntityManager#remove(Object)
     */
    void remove(T entity);
    /**
     * 検索
     * <ul>
     * <li>エンティティを一次キーで検索する。</li>
     * </ul>
     * @param primaryKey 一次キー
     * @return 検索した管理エンティティ
     * @throws IllegalArgumentException
     *             エンティティオブジェクト型でない、または一次キーオブジェクト型でないかNULLのとき
     * @see EntityManager#find(Class, Object)
     */
    T find(Object primaryKey);
    /**
     * 検索
     * <ul>
     * <li>エンティティを一次キーで検索する。</li>
     * </ul>
     * @param primaryKey 一次キー
     * @param lockMode 排他モード
     * @return 検索した管理エンティティ
     * @throws IllegalArgumentException
     *             エンティティオブジェクト型でない、または一次キーオブジェクト型でないかNULLのとき
     * @throws TransactionRequiredException トランザクションが存在しないとき
     * @throws OptimisticLockException 楽観ロックの例外が発生したとき
     * @throws PessimisticLockException 悲観ロックの例外が発生したとき
     * @throws LockTimeoutException 悲観ロックのタイムアウトが発生したとき
     * @throws PersistenceException 未サポートのロックを実行したとき
     * @see EntityManager#find(Class, Object, LockModeType)
     */
    T find(Object primaryKey, LockModeType lockMode);
    /**
     * 検索
     * <ul>
     * <li>(遅延フェッチできる)エンティティを一次キーで検索する。</li>
     * </ul>
     * @param primaryKey 一次キー
     * @return 検索した管理エンティティ
     * @throws IllegalArgumentException
     *             エンティティオブジェクト型でない、または一次キーオブジェクト型でないかNULLのとき
     * @throws EntityNotFoundException
     *             エンティティにアクセスできないとき
     * @see EntityManager#getReference(Class, Object)
     */
    T getReference(Object primaryKey);
    /**
     * 同期
     * <dl>
     * <dt>事前条件</dt>
     * <dd>throws項を参照すること。</dd>
     * <dt>事後条件</dt>
     * <dd>管理エンティティをデータベースと同期すること。</dd>
     * </dl>
     * @throws TransactionRequiredException トランザクションが存在しないとき
     * @throws PersistenceException データベースの同期が失敗したとき
     * @see EntityManager#flush()
     */
    void flush();
    /**
     * 同期モードの設定
     * <p>
     * 永続化コンテキスト中の全オブジェクトへ適用する同期モードを設定する。
     * </p>
     * @param flushMode 同期モード
     * @see EntityManager#setFlushMode(FlushModeType)
     */
    void setFlushMode(FlushModeType flushMode);
    /**
     * 同期モードの取得
     * <p>
     * 永続化コンテキスト中の全オブジェクトへ適用する同期モードを取得する。
     * </p>
     * @return 同期モード
     * @see EntityManager#getFlushMode()
     */
    FlushModeType getFlushMode();
    /**
     * 排他
     * <dl>
     * <dt>事前条件</dt>
     * <dd>throws項を参照すること。</dd>
     * <dt>事後条件</dt>
     * <dd>管理エンティティを排他すること。排他モードは{@link LockModeType}を参照。</dd>
     * </dl>
     * @param entity 管理エンティティ
     * @param lockMode 排他モード
     * @throws PersistenceException 未サポートの排他を実行したとき
     * @throws IllegalArgumentException エンティティオブジェクト型でない、または分離エンティティのとき
     * @throws TransactionRequiredException トランザクションが存在しないとき
     * @see EntityManager#lock(Object, LockModeType)
     */
    void lock(T entity, LockModeType lockMode);
    /**
     * 再更新
     * <p>
     * エンティティをデータベースから再更新する。
     * </p>
     * @param entity 管理エンティティ
     * @throws IllegalArgumentException エンティティオブジェクト型でない、または管理エンティティでないとき
     * @throws TransactionRequiredException トランザクションが存在しないとき
     * @throws EntityNotFoundException エンティティがデータベースにないとき
     */
    void refresh(T entity);
    /**
     * 再更新
     * <p>
     * エンティティをデータベースから再更新する。同時に排他を実行する。排他モードは{@link LockModeType}を参照。
     * </p>
     * @param entity 管理エンティティ
     * @param lockMode 排他モード
     * @throws IllegalArgumentException エンティティオブジェクト型でない、または管理エンティティでないとき
     * @throws TransactionRequiredException トランザクションが存在しないとき
     * @throws EntityNotFoundException エンティティがデータベースにないとき
     */
    void refresh(T entity, LockModeType lockMode);
    /**
     * 分離
     * <dl>
     * <dt>事後条件</dt>
     * <dd>すべての管理エンティティを分離エンティティにすること。なお同期前のデータは永続化しない。</dd>
     * </dl>
     * @see EntityManager#clear()
     */
    void clear();
    /**
     * 分離
     * <dl>
     * <dt>事前条件</dt>
     * <dd>throws項を参照すること。</dd>
     * <dt>事後条件</dt>
     * <dd>管理エンティティを分離エンティティにすること。なお同期前のデータは永続化しない。</dd>
     * </dl>
     * @param entity 管理エンティティ
     * @throws IllegalArgumentException エンティティでないとき
     * @see EntityManager#detach(Object)
     */
    void detach(T entity);
    /**
     * 在否
     * <p>
     * エンティティが永続化コンテキスト中に存在するか確認する。
     * </p>
     * @param entity エンティティ
     * @return 在否
     * @throws IllegalArgumentException エンティティオブジェクト型でない
     */
    boolean contains(T entity);
    /**
     * 排他モードの取得
     * @param entity 管理エンティティ
     * @return 排他モード
     */
    LockModeType getLockMode(Object entity);
    /**
     * プロパティの設定
     * <p>
     * エンティティマネージャのプロパティまたはヒントを設定する。
     * </p>
     * @param name プロパティ名
     * @param value プロパティ値
     * @throws IllegalArgumentException プロパティ値が間違っているとき
     */
    void setProperty(String name, Object value);
    /**
     * プロパティの取得
     * <p>
     * エンティティマネージャのプロパティとヒントを取得する。
     * </p>
     * @return プロパティ
     */
    Map<String, Object> getProperties();
    /**
     * トランザクション参加
     * <p>
     * アプリケーション管理のJTAエンティティマネージャを、現在のJTAトランザクションに関連づける。
     * </p>
     * @throws TransactionRequiredException トランザクションが存在しないとき
     */
    void joinTransaction();
    /**
     * トランザクション参加の確認
     * <p>
     * 現在のJTAトランザクションに参加しているか確認する。
     * </p>
     * @return トランザクション参加
     */
    boolean isJoinedToTransaction();
    /**
     * 閉鎖
     * <p>
     * アプリケーション管理のエンティティマネージャをクローズする。
     * </p>
     * @throws IllegalStateException コンテナ管理のエンティティマネージャであるとき
     */
    void close();
    /**
     * 開閉
     * <p>
     * エンティティマネージャがオープンしているかを確認する。
     * </p>
     * @return 開閉
     */
    boolean isOpen();
    /**
     * トランザクションの取得
     * <p>
     * 複数トランザクションを直列に開始して、コミットするために使用する。
     * </p>
     * @return トランザクション
     * @throws IllegalStateException JTAエンティティマネージャであるとき
     */
    EntityTransaction getTransaction();
    /**
     * エンティティマネージャファクトリの取得
     * @return エンティティマネージャファクトリ
     * @throws IllegalStateException エンティティマネージャがクローズしているとき
     */
    EntityManagerFactory getEntityManagerFactory();
    /**
     * メタモデルの取得
     * @return メタモデル
     * @throws IllegalStateException エンティティマネージャがクローズしているとき
     */
    Metamodel getMetamodel();
}