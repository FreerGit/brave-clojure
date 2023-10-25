(ns freergit.chap5
  (:require [clojure.string :as s]))

(defn wisdom
  [words]
  (str words ", Daniel-san"))

(wisdom "Always bathe on Fridays")

(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})

(def c-int (comp :intelligence :attributes))

(c-int character)

((comp inc inc inc) 5)

(defn two-comp
  [f g]
  (fn [& args]
    (f (apply g args))))

((two-comp inc inc) 5)

(defn sleepy-identity
  "Returns the given value after 1 second"
  [x]
  (Thread/sleep 1000)
  x)

(def memo-sleepy-identity (memoize sleepy-identity))

(memo-sleepy-identity "Mr. Fantastico")

(defn attr
  [to-get]
  (to-get (:attributes character)))

(attr :intelligence)

(defn comp'
  [& fs]
  (reduce (fn [f g]
            #(f (apply g %&))) fs))

((comp' inc inc inc inc inc) 5)

(update-in character [:attributes :intelligence] + 20)

;; (defn update-in' [p &getters])

(reduce get character  [:attributes :intelligence])

(defn update-in'
  ([p [field & fields] fn v]
   (print fields)
   (prn field)
   (if (nil? fields)
     (update p field fn v)
     (update-in' (get p field) fields fn v))))

;; (map 5 [inc inc])

(update-in' character [:attributes :intelligence] + 10)