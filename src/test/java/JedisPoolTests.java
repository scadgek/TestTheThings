import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class JedisPoolTests
{
  @Test
  public void nullPasswordShouldBeAccepted()
  {
    connectWithPassword( null );
  }

  @Test( expected = JedisConnectionException.class )
  public void emptyPasswordShouldNotBeAccepted()
  {
    connectWithPassword( "" );
  }

  @Test( expected = JedisConnectionException.class )
  public void whitespacePasswordShouldNotBeAccepted()
  {
    connectWithPassword( " " );
  }

  @Test( expected = JedisConnectionException.class )
  public void whitespacesPasswordShouldNotBeAccepted()
  {
    connectWithPassword( "   " );
  }

  /**
   * Creates a JedisPool with default config, sets the given password and
   * tries to do a ping to Redis.
   *
   * @param password password value to be used
   */
  private void connectWithPassword( String password )
  {
    JedisPoolConfig poolConfig = new JedisPoolConfig();
    JedisPool jedisPool = new JedisPool( poolConfig, Protocol.DEFAULT_HOST, Protocol.DEFAULT_PORT, Protocol.DEFAULT_TIMEOUT, password );
    try (Jedis jedis = jedisPool.getResource())
    {
      jedis.ping();
    }
  }
}
