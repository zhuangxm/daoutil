(ns daoutil.test.id
  (:use [daoutil.id]
        [daoutil.db]
        [midje.sweet]))

(init-idset memory-db)
(swap! idset (fn [_] {}))

(fact
  (id-generator db :test) => 1
  (id-generator db :test) => 2
  (swap! idset (fn [_] {}))
  (id-generator db :test) => (+ fetch-size 1)
  (id-generator db :test) => (+ fetch-size 2)
  (id-generator db :test1) => 1
  (id-generator db :test1) => 2)
