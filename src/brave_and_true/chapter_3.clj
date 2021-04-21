(ns brave-and-true.chapter-3
  (:require [schema.core :as s]))

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 1}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 2}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))

(clojure.pprint/pprint (symmetrize-body-parts asym-hobbit-body-parts))

(s/defn convert-keyword-to-string :- s/Str
  [keyword :- s/Keyword]
  (str keyword))

(s/defn list->vector :- [s/Any]
  [list-of-elements]
  (into (vector) list-of-elements))

(s/defn build-a-hashmap-with-two-elements
  [element-1
   element-2]
  (hash-map element-1 element-2))

(s/defn build-a-hashset-with-two-elements :- {s/Any s/Any}
  [& elements]
  (apply hash-set elements))

(s/defn adds-100 :- s/Int
  [number :- s/Int]
  (+ number 100))

(s/defn dec-maker :- s/Int
  [dec-by]
  #(- % dec-by))

(def dec9 (dec-maker 9))

(s/defn mapset
  [function-to-be-applied
   elements :- [s/Int]]
  (->> elements
      (map function-to-be-applied)
       set))