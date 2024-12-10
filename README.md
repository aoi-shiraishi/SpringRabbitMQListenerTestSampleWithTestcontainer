# RabbitMQのListenerをテストするサンプルコード

## 環境

- OS: macOS Sequoia 15.1.1
- container: Docker version 27.3.1
- container runtime: colima version 0.8.0

※docker,docker-compose,colimaはHomebrewでインストールしたものを使用

## 事前準備

### 環境変数設定

zshの場合、`~/.zshrc`に以下を追記。

```sh
export TESTCONTAINERS_DOCKER_SOCKET_OVERRIDE=/var/run/docker.sock
export TESTCONTAINERS_HOST_OVERRIDE=$(colima ls -j | jq -r '.address')
export DOCKER_HOST="unix://${HOME}/.colima/default/docker.sock"
```

### colimaの起動

```sh
colima start --network-address
```

※--network-addressオプションを付けることで、IPアドレスが設定される
