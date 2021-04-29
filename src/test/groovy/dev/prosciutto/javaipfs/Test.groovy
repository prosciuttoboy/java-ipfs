package dev.prosciutto.javaipfs

import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.wait.strategy.Wait
import org.testcontainers.spock.Testcontainers
import org.testcontainers.utility.DockerImageName
import spock.lang.Shared
import spock.lang.Specification

@Testcontainers
final class Test extends Specification {

  @Shared
  private GenericContainer<GenericContainer> ipfsContainer = new GenericContainer<>(DockerImageName.parse('ipfs/go-ipfs'))
      .withExposedPorts(5001)
      .waitingFor(Wait.forLogMessage("Gateway \\(readonly\\) server listening on /ip4/0\\.0\\.0\\.0/tcp/8080\n", 1))

  def 'test'() {
    expect:
    1 == 1
  }
}
