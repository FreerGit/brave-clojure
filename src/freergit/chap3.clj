(ns freergit.chap3
  (:require
   [clojure.string :as s]))

(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOOOOOOMED!")))

(error-message :mild)

(get {:a 0 :b 1} :b)

(get {:a 0 :b 1} :c)

(get-in {:a 0 :b {:c "c"}} [:b :c])

({:a 0 :b 1} :b)

(({:a 0 :b {:c "c"}} :b) :c)

(time (get (range 10000) 0))

(time (get [3 {:name "fdsfsdfads"} "c"] 1))

(vector 1 2 3)

(conj [1 2 3] 4)
'(1 2 3 4)

#{1 2 3 "hej"}

(hash-set 1 1 2 2 2 3)

(conj #{:a :b} :b)

(set [3 3 3 4 4])

(contains? #{:a :b} :a)

(contains? #{:a :b} :c)

(map inc [0 1 2 3])

(defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))

(x-chop "Kanye West" "slap")
(x-chop "Kanye West")

(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my favorite things: "
       (s/join ", " things)))

(favorite-things "Doreen" "gum" "shoes" "kara-te")

(defn my-first
  [[first-thing, second-thing]]
  (str first-thing ", " second-thing))

(my-first ["oven" "bike" "war-axe"])

(defn announce-treasure-location
  [{lat :lat lng :lng}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(announce-treasure-location {:lat 28.22 :lng 81.33})

(#(* % 3) 8)

(defn inc-maker
  "Create a custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 7)

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
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(defn matching-part
  [part]
  {:name (s/replace (:name part) #"^left-" "right-")
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

(symmetrize-body-parts asym-hobbit-body-parts)

(reduce + [1 2 3 4])

(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          asym-body-parts))

(better-symmetrize-body-parts asym-hobbit-body-parts)

;; Exercises
(str "hej" "svej")

(vector 1 2 2 3 4)

(list 1 2 23)

(hash-map "a" "b")

(hash-set 1 2 2 2)

(defn inc-by-100 [x] (+ x 100))

(inc-by-100 1)


(defn dec-maker [dec-by] #(- % dec-by))
(def dec9 (dec-maker 9))
(dec9 10)

(defn mapset [fn container] (set (map fn container)))
(mapset inc [1 1 2 2])

