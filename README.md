# pattern-lock

Takes a sequence of numbers representing dots to connect and determines
if it represents a valid pattern.

Android has a pattern lock screen with 9 dots:
* 1 2 3
* 4 5 6
* 7 8 9

Dots may be connected in any order, but:
* Each dot may only be used once
* Dots must be connected with straight lines
* A dot may not be crossed without being used

### Task
Write a function in any language that takes a sequence of numbers representing
dots to connect and determines if it represents a valid pattern.

# Clojure Test Cases
* (is (true?  (valid-path [1 6 7 4])))   ;; knights jump is valid
* (is (true?  (valid-path [2 1 3])))     ;; 2 is already used, so we can cross it
* (is (false? (valid-path [1 3 2])))     ;; can&#39;t get from 1 to 3 without using 2 first
* (is (false? (valid-path [1 9])))       ;; can&#39;t cross 5 without using
* (is (false? (valid-path [1 2 3 2 1]))) ;; can&#39;t use dots more than once
* (is (false? (valid-path [0 1 2 3])))   ;; there&#39;s no dot 0

## Usage

Use "lein run" to run test cases.

## License

Copyright © 2020 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
