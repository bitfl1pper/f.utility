(ns f.utility)

;;;; Yet another utility library: f.utility

;;; Drop Stuff

(defn drop-nil
  "Drops nil values."
  [col]
  (filter #(not= nil %) col))

(defn drop-if
  "Drops values from a collection if they are equal to "
  [val col]
  (filter #(not= val %) col))

(defn drop-if-not
  "Drops values from a collection if they are not equal to "
  [val col]
  (filter #(= val %) col))

(defn drop-if-less
  "Drops values that are less than "
  [val col]
  (filter #(< val %) col))

(defn drop-if-greater
  "Drops values that are greater than "
  [val col]
  (filter #(> val %) col))

;;; Uncat

(defn between? [val r0 r1]
  (if (or (and (< val r0) (> val r1))
          (and (> val r0) (< val r1)))
    true
    false))

;;; Count Stuff

(defn unique
  "Counts how many distinct items in col."
  [col]
  (count (distinct col)))

;;; Load / Read Stuff

(defn read-file-by-line
  "Read file, line by line.
   As seen on stackoverflow!"
  [file]
  (with-open [rdr (clojure.java.io/reader file)]
    (doall (line-seq rdr))))
