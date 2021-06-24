/*
 * Copyright (c) 2011-2021 VMware, Inc. or its affiliates, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package reactor.netty.udp;

import java.util.Objects;
import java.util.function.Function;

import io.netty.bootstrap.Bootstrap;

/**
 * @author Stephane Maldini
 */
final class UdpClientBootstrap extends UdpClientOperator {


	final Function<? super Bootstrap, ? extends Bootstrap> bootstrapMapper;

	UdpClientBootstrap(UdpClient client,
			Function<? super Bootstrap, ? extends Bootstrap> bootstrapMapper) {
		super(client);
		this.bootstrapMapper = Objects.requireNonNull(bootstrapMapper, "bootstrapMapper");
	}

	@Override
	protected Bootstrap configure() {
		return Objects.requireNonNull(bootstrapMapper.apply(source.configure()), "bootstrapMapper");
	}
}
