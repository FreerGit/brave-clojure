(ns freergit.chpa9)


(let [result (future (Thread/sleep 3000)
                     (+ 1 1))]
  (println "The result is: " @result)
  (println "It will be at least 3 seconds before I print"))

(defn html [] (slurp "https://www.google.com/search?q%3hej"))

