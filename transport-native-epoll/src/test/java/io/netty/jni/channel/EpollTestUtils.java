/*
 * Copyright 2014 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.jni.channel;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.testsuite.transport.TestsuitePermutation;

import java.util.Collections;
import java.util.List;

final class EpollTestUtils {
    static List<TestsuitePermutation.BootstrapComboFactory<ServerBootstrap, Bootstrap>> newFactories() {
        return Collections.<TestsuitePermutation.BootstrapComboFactory<ServerBootstrap, Bootstrap>>singletonList(
                new TestsuitePermutation.BootstrapComboFactory<ServerBootstrap, Bootstrap>() {
            @Override
            public ServerBootstrap newServerInstance() {
                return new ServerBootstrap().group(
                        new EpollEventLoopGroup()).channel(EpollServerSocketChannel.class);
            }

            @Override
            public Bootstrap newClientInstance() {
                return new Bootstrap().group(new EpollEventLoopGroup()).channel(EpollSocketChannel.class);
            }
        });
    }

    private EpollTestUtils() {
        // utility class
    }
}