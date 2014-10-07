(ns f.utility.html
  (:require [net.cgrand.enlive-html :as html]))

;;; this is probably buggy, took from another of my proje, TOFIX
;;; most of this is from/or inspired by David Nolen's enlive tutorial

(defn text-reader [text-source]
  "This function will accept a text file and form a reader."
  ;; TODO: Implement text reader function. [check]
  (with-open [rdr (io/reader text-source)]
    (doall (line-seq rdr))))

(defn html-offline-parse [hypertext]
  "Parse html found on file system."
  ;; TODO: parse html from url as in scrape1.clj
  (html/html-resource (io/as-file hypertext)))

(defn fetch-page [url]
  (html/html-resource (java.net.URL. url)))

(defn html-online-parse [hypertext]
  (html/html-resource (io/as-url hypertext)))

(defn html-p [web-hypertext]
  (map html/text (html/select (html-online-parse web-hypertext) [:p])))

(defn html-get-p [hypertext]
  "Pull out paragraph elements from html on disk."
  (map html/text (html/select (html-offline-parse hypertext) [:p])))

(defn html-get-h1 [hypertext]
  "Pull out h1 elements from html on disk."
  (map html/text (html/select (html-offline-parse hypertext) [:h1])))

(defn html-get-a [hypertext]
  "Pull out <a> elements from html on disk."
  (map html/text (html/select (html-offline-parse hypertext) [:a])))
