package storage

import zio._

trait Storage[K, V] {
  def save(key: K, value: V): Task[Unit]

  def get(key: K): Task[Option[V]]
}

class InMemoryStorage[K, V](ref: Ref[Map[K, V]]) extends Storage[K, V] {
  def save(key: K, value: V): UIO[Unit] = ref.update(_ + (key -> value))

  def get(key: K): UIO[Option[V]] = ref.get.map(_.get(key))
}

object Storage {
  def mkInMemory[K, V]: UIO[Storage[K, V]] =
    Ref.make(Map.empty[K, V]).map(new InMemoryStorage(_))
}
