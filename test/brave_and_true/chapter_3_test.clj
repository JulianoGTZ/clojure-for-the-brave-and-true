(ns brave-and-true.chapter-3-test
  (:require [clojure.test :refer :all]
            [brave-and-true.chapter-3 :as chapter-2]))

(deftest exercise-1
  "Use the str, vector, hash-map and hash-set"
  (testing "Using str"
    (is (= (chapter-2/convert-keyword-to-string :test) ":test")))

  (testing "Using vector"
    (is (= (chapter-2/list->vector '(1 2 3 4)) [1 2 3 4])))

  (testing "Using hashmap"
    (is (= (chapter-2/build-a-hashmap-with-two-elements "da hora" :avida) {"da hora" :avida})))

  (testing "Using hashset"
    (is (= (chapter-2/build-a-hashset-with-two-elements 1 1 2 2 3 4 5) #{1 2 3 4 5}))))

(deftest exercise-2
  "Write a function that takes a number and adds 100 to it"
  (testing "Taking a number and adding 100 to it"
    (is (= (chapter-2/adds-100 100) 200))))

(deftest exercise-3
  "Write a function, dec-maker, that works exactly like the function inc-maker, except with the subtraction"
  (testing "Should decrease the given number"
    (is (= (chapter-2/dec9 10) 1))))

(deftest exercise-4
  "Writes a function mapset, that works like map except the return value is a set"
  (testing "Should return a set"
    (is (= (chapter-2/mapset inc [1 1 2 2]) #{ 2 3}))))
