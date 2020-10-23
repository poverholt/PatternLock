(ns pattern-lock.core
  (:gen-class)
  (:use clojure.test))

;; Any number can connect to any other unvisited number, but with exception
;; that there are some crossed dots that must be already visited
(def crossed
  [{}              ; From init, represented by 0, there will be no cross
   {3 2, 7 4, 9 5} ; From digit 1, to get to 3, must cross 2, etc.
   {8 5}           ; From digit 2, etc
   {1 2, 7 5, 9 6}
   {6 5}
   {}
   {4 5}
   {1 4, 3 5, 9 8}
   {2 5}
   {1 5, 3 6, 7 8}])

;; Returns which dot prev crosses in order to get to next
(defn crosses [prev next]
  (if (nil? prev) nil ((crossed prev) next)))

;; visited is a set of all visited dots, including prev
;; prev is where we are now
;; next is where we are trying to go
(defn valid-step? [visited, prev, next]
  (and
    (< 0 next 10)
    (not (visited next))
    (if-let [crossed (crosses prev next)] (visited crossed) true)))

(defn valid-path? [s]
  (if (empty? s)
    false
    (loop [prev 0
           visited #{prev}
           s s]
      (if (empty? s)
        true
        (if (not (valid-step? visited prev (first s)))
          false
          (recur (first s) (conj visited (first s)) (rest s)))))))

(def tests {
    [1 6 7 4] true      ;; knights jump is valid
    [2 1 3] true        ;; 2 is already used, so we can cross it
    [1 3 2] false       ;; can't get from 1 to 3 without using 2 first
    [1 9] false         ;; can't cross 5 without using
    [1 2 3 2 1] false   ;; can't use dots more than once
    [0 1 2 3] false})   ;; 0 is invalid

(defn -main
  "Runs test cases for pattern lock validator."
  [& args]
  (when 
    (every? #(is (= (valid-path? (first %)) (second %))) tests)
    (println "All tests passed!")))


