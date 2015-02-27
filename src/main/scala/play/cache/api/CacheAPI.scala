package play.cache.api

import scala.concurrent.Future
import scala.util.Try

/**
 * <p>Non-blocking cache API, inspired by basic Play play.api.cache.CacheAPI.</p>
 */
trait CacheAPI {

  /** Retrieve a value from the cache.
    *
    * @param key cache storage key
    * @return stored record, Some if exists, otherwise None
    */
  def get( key: String ): Future[ Option[ String ] ]

  /** Determines whether value exists in cache.
    *
    * @param key cache storage key
    * @return record existence, true if exists, otherwise false
    */
  def exists( key: String ): Future[ Boolean ]

  /** Set a value into the cache. Expiration time in seconds (0 second means eternity).
    *
    * @param key cache storage key
    * @param value value to store
    * @param expiration record duration in seconds
    * @return operation success
    */
  def set( key: String, value: String, expiration: Int ): Future[ Try[ String ] ]

  /** Remove a value from the cache
    * @param key cache storage key
    * @return operation success
    */
  def remove( key: String ): Future[ Try[ String ] ]

  /** Remove all keys in cache
    *
    * @return operation success
    */
  def invalidate( ): Future[ Try[ String ] ]
}