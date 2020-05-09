(ns clojure-noob.core
  (:gen-class))

(defn announce-treasure-location
  [{lat :lat lng :lng}]
  (println (str "Treasure lat:" lat)
           (println (str "Treasure lgn" lng))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (announce-treasure-location {:lat 28.22 :lng 81.33})

  (println "Hello, World!"))
