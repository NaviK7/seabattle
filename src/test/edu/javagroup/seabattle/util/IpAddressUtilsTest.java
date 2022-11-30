package edu.javagroup.seabattle.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author kaa
 * @version 1.3
 */
@SpringBootTest
public class IpAddressUtilsTest {

    @Test
    void ipAddressUtilsTest() {
        assertThat(IpAddressUtils.isIpAddress(null)).isFalse();
        assertThat(IpAddressUtils.isIpAddress("")).isFalse();
        assertThat(IpAddressUtils.isIpAddress(" ")).isFalse();
        assertThat(IpAddressUtils.isIpAddress(".")).isFalse();
        assertThat(IpAddressUtils.isIpAddress(" . ")).isFalse();
        assertThat(IpAddressUtils.isIpAddress(". . ")).isFalse();
        assertThat(IpAddressUtils.isIpAddress(" . .")).isFalse();
        assertThat(IpAddressUtils.isIpAddress(" . . . . ")).isFalse();
        assertThat(IpAddressUtils.isIpAddress(". .. .")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("....")).isFalse();
        assertThat(IpAddressUtils.isIpAddress(",")).isFalse();
        assertThat(IpAddressUtils.isIpAddress(" , ")).isFalse();
        assertThat(IpAddressUtils.isIpAddress(", , ")).isFalse();
        assertThat(IpAddressUtils.isIpAddress(" , ,")).isFalse();
        assertThat(IpAddressUtils.isIpAddress(" , , ")).isFalse();
        assertThat(IpAddressUtils.isIpAddress(" , , , , ")).isFalse();
        assertThat(IpAddressUtils.isIpAddress(", ,, ,")).isFalse();
        assertThat(IpAddressUtils.isIpAddress(",,,,")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("127.0.0.1")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("127.000.000.001")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("127.1.1.1.")).isFalse();
        assertThat(IpAddressUtils.isIpAddress(".127.1.1.1.")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("localhost")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("192,168,1,11")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("0.1.1.1")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("256.1.1.1")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("1.256.1.1")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("1.1.256.1")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("1.1.1.256")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("1..1.1")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("1.1..1")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("1.1.1.")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("-1.1.1.1")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("1.-1.1.1")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("1.1.-1.1")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("1.1.1.-1")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("a.b.c.d")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("0.1.1.1")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("00.1.1.1")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("000.1.1.1")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("19a.b68.c.1d1")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("0001.0000.0000.0000")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("it's.very.long.line")).isFalse();
        assertThat(IpAddressUtils.isIpAddress("1.0.0.0")).isTrue();
        assertThat(IpAddressUtils.isIpAddress("001.000.000.000")).isTrue();
        assertThat(IpAddressUtils.isIpAddress("192.168.010.011")).isTrue();
        assertThat(IpAddressUtils.isIpAddress("192.168.001.011")).isTrue();
    }
}