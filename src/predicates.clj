(ns predicates)

(defn sum-f [f g x]
  (+
    (f x)
    (g x)))


(defn less-than [n]
   (fn
     [k]
     (< k n)))

(defn equal-to [n]
  (fn
     [k]
     (== k n)))


(defn set->predicate [a-set]
  (fn [coll] (contains? a-set coll)))


(defn pred-and [pred1 pred2]
  (fn [coll]
    (and
      (pred1 coll)
      (pred2 coll))))


(defn pred-or [pred1 pred2]
  (fn [coll]
    (or
      (pred1 coll)
      (pred2 coll))))


(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  ;(or
    (every? whitespace? string))
    ;(empty? string))) ;not needed b/c the test cases are using escape characters which the Java method in whitespace? sees as whitespace



(defn has-award? [book award]
  (contains? (:awards book) award))


(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [awarded (fn [a] (has-award? book a))]
    (every? awarded awards)))


(defn my-some [pred a-seq]
  (some pred a-seq))

(defn my-some [pred a-seq]
  (first
    (filter
      identity
      (map
        pred
        a-seq))))


(defn my-every? [pred a-seq]
  (empty?
    (filter
      identity
      (map
        (complement pred)
        a-seq))))


(defn prime? [n]
  (let
    [pred (fn [d] (= 0 (mod n d)))]
    (not
      (some
        pred
        (range 2 n))))) ;numbers in this range exclude 1 and n. If any other number/divisor mods eval to zero when dividing n, the number is not prime


;^^
