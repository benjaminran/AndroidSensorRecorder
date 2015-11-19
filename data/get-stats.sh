#!/bin/bash

#
#   Usage: get-stats.sh datadir outputdir
#
#       datadir: a directory containing sqlite .db files
#       outputdir: the directory for output
#

mkdir -p $2
find $1 -name '*.db' | while read line; do
    outfile=$2/`basename $line`.stats
    echo ========== $outfile ========== >$outfile
    ./sqlite3 $line <stats.sql >>$outfile
    cat $outfile
    echo
done
