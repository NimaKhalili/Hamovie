package com.example.hamovie;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MovieDao_Impl implements MovieDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MovieEntry> __insertionAdapterOfMovieEntry;

  public MovieDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMovieEntry = new EntityInsertionAdapter<MovieEntry>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `movie` (`id`,`name`,`genre`,`year`,`explain`,`poster`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MovieEntry value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getGenre() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGenre());
        }
        stmt.bindLong(4, value.getYear());
        if (value.getExplain() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getExplain());
        }
        stmt.bindLong(6, value.getPoster());
      }
    };
  }

  @Override
  public void insertAllMovies(final List<MovieEntry> movieList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMovieEntry.insert(movieList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<MovieEntry> getAllMovies() {
    final String _sql = "SELECT * FROM movie";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfExplain = CursorUtil.getColumnIndexOrThrow(_cursor, "explain");
      final int _cursorIndexOfPoster = CursorUtil.getColumnIndexOrThrow(_cursor, "poster");
      final List<MovieEntry> _result = new ArrayList<MovieEntry>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MovieEntry _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpGenre;
        if (_cursor.isNull(_cursorIndexOfGenre)) {
          _tmpGenre = null;
        } else {
          _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
        }
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final String _tmpExplain;
        if (_cursor.isNull(_cursorIndexOfExplain)) {
          _tmpExplain = null;
        } else {
          _tmpExplain = _cursor.getString(_cursorIndexOfExplain);
        }
        final int _tmpPoster;
        _tmpPoster = _cursor.getInt(_cursorIndexOfPoster);
        _item = new MovieEntry(_tmpId,_tmpName,_tmpGenre,_tmpYear,_tmpExplain,_tmpPoster);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MovieEntry> getFilms() {
    final String _sql = "SELECT * FROM movie WHERE genre != 'سریال' and genre != 'انیمیشن'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfExplain = CursorUtil.getColumnIndexOrThrow(_cursor, "explain");
      final int _cursorIndexOfPoster = CursorUtil.getColumnIndexOrThrow(_cursor, "poster");
      final List<MovieEntry> _result = new ArrayList<MovieEntry>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MovieEntry _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpGenre;
        if (_cursor.isNull(_cursorIndexOfGenre)) {
          _tmpGenre = null;
        } else {
          _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
        }
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final String _tmpExplain;
        if (_cursor.isNull(_cursorIndexOfExplain)) {
          _tmpExplain = null;
        } else {
          _tmpExplain = _cursor.getString(_cursorIndexOfExplain);
        }
        final int _tmpPoster;
        _tmpPoster = _cursor.getInt(_cursorIndexOfPoster);
        _item = new MovieEntry(_tmpId,_tmpName,_tmpGenre,_tmpYear,_tmpExplain,_tmpPoster);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MovieEntry> getSerials() {
    final String _sql = "SELECT * FROM movie WHERE genre = 'سریال'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfExplain = CursorUtil.getColumnIndexOrThrow(_cursor, "explain");
      final int _cursorIndexOfPoster = CursorUtil.getColumnIndexOrThrow(_cursor, "poster");
      final List<MovieEntry> _result = new ArrayList<MovieEntry>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MovieEntry _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpGenre;
        if (_cursor.isNull(_cursorIndexOfGenre)) {
          _tmpGenre = null;
        } else {
          _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
        }
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final String _tmpExplain;
        if (_cursor.isNull(_cursorIndexOfExplain)) {
          _tmpExplain = null;
        } else {
          _tmpExplain = _cursor.getString(_cursorIndexOfExplain);
        }
        final int _tmpPoster;
        _tmpPoster = _cursor.getInt(_cursorIndexOfPoster);
        _item = new MovieEntry(_tmpId,_tmpName,_tmpGenre,_tmpYear,_tmpExplain,_tmpPoster);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MovieEntry> getAnimations() {
    final String _sql = "SELECT * FROM movie WHERE genre = 'انیمیشن'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfExplain = CursorUtil.getColumnIndexOrThrow(_cursor, "explain");
      final int _cursorIndexOfPoster = CursorUtil.getColumnIndexOrThrow(_cursor, "poster");
      final List<MovieEntry> _result = new ArrayList<MovieEntry>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MovieEntry _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpGenre;
        if (_cursor.isNull(_cursorIndexOfGenre)) {
          _tmpGenre = null;
        } else {
          _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
        }
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final String _tmpExplain;
        if (_cursor.isNull(_cursorIndexOfExplain)) {
          _tmpExplain = null;
        } else {
          _tmpExplain = _cursor.getString(_cursorIndexOfExplain);
        }
        final int _tmpPoster;
        _tmpPoster = _cursor.getInt(_cursorIndexOfPoster);
        _item = new MovieEntry(_tmpId,_tmpName,_tmpGenre,_tmpYear,_tmpExplain,_tmpPoster);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MovieEntry> getAllMoviesOrderByYear() {
    final String _sql = "SELECT * FROM movie ORDER BY year DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfExplain = CursorUtil.getColumnIndexOrThrow(_cursor, "explain");
      final int _cursorIndexOfPoster = CursorUtil.getColumnIndexOrThrow(_cursor, "poster");
      final List<MovieEntry> _result = new ArrayList<MovieEntry>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MovieEntry _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpGenre;
        if (_cursor.isNull(_cursorIndexOfGenre)) {
          _tmpGenre = null;
        } else {
          _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
        }
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final String _tmpExplain;
        if (_cursor.isNull(_cursorIndexOfExplain)) {
          _tmpExplain = null;
        } else {
          _tmpExplain = _cursor.getString(_cursorIndexOfExplain);
        }
        final int _tmpPoster;
        _tmpPoster = _cursor.getInt(_cursorIndexOfPoster);
        _item = new MovieEntry(_tmpId,_tmpName,_tmpGenre,_tmpYear,_tmpExplain,_tmpPoster);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MovieEntry> getActions() {
    final String _sql = "SELECT * FROM movie WHERE genre = 'اکشن'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfExplain = CursorUtil.getColumnIndexOrThrow(_cursor, "explain");
      final int _cursorIndexOfPoster = CursorUtil.getColumnIndexOrThrow(_cursor, "poster");
      final List<MovieEntry> _result = new ArrayList<MovieEntry>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MovieEntry _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpGenre;
        if (_cursor.isNull(_cursorIndexOfGenre)) {
          _tmpGenre = null;
        } else {
          _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
        }
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final String _tmpExplain;
        if (_cursor.isNull(_cursorIndexOfExplain)) {
          _tmpExplain = null;
        } else {
          _tmpExplain = _cursor.getString(_cursorIndexOfExplain);
        }
        final int _tmpPoster;
        _tmpPoster = _cursor.getInt(_cursorIndexOfPoster);
        _item = new MovieEntry(_tmpId,_tmpName,_tmpGenre,_tmpYear,_tmpExplain,_tmpPoster);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MovieEntry> getComedies() {
    final String _sql = "SELECT * FROM movie WHERE genre = 'کمدی'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfExplain = CursorUtil.getColumnIndexOrThrow(_cursor, "explain");
      final int _cursorIndexOfPoster = CursorUtil.getColumnIndexOrThrow(_cursor, "poster");
      final List<MovieEntry> _result = new ArrayList<MovieEntry>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MovieEntry _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpGenre;
        if (_cursor.isNull(_cursorIndexOfGenre)) {
          _tmpGenre = null;
        } else {
          _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
        }
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final String _tmpExplain;
        if (_cursor.isNull(_cursorIndexOfExplain)) {
          _tmpExplain = null;
        } else {
          _tmpExplain = _cursor.getString(_cursorIndexOfExplain);
        }
        final int _tmpPoster;
        _tmpPoster = _cursor.getInt(_cursorIndexOfPoster);
        _item = new MovieEntry(_tmpId,_tmpName,_tmpGenre,_tmpYear,_tmpExplain,_tmpPoster);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MovieEntry> getCrimes() {
    final String _sql = "SELECT * FROM movie WHERE genre = 'جنایی'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfExplain = CursorUtil.getColumnIndexOrThrow(_cursor, "explain");
      final int _cursorIndexOfPoster = CursorUtil.getColumnIndexOrThrow(_cursor, "poster");
      final List<MovieEntry> _result = new ArrayList<MovieEntry>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MovieEntry _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpGenre;
        if (_cursor.isNull(_cursorIndexOfGenre)) {
          _tmpGenre = null;
        } else {
          _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
        }
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final String _tmpExplain;
        if (_cursor.isNull(_cursorIndexOfExplain)) {
          _tmpExplain = null;
        } else {
          _tmpExplain = _cursor.getString(_cursorIndexOfExplain);
        }
        final int _tmpPoster;
        _tmpPoster = _cursor.getInt(_cursorIndexOfPoster);
        _item = new MovieEntry(_tmpId,_tmpName,_tmpGenre,_tmpYear,_tmpExplain,_tmpPoster);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MovieEntry> getHorrors() {
    final String _sql = "SELECT * FROM movie WHERE genre = 'ترسناک'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfExplain = CursorUtil.getColumnIndexOrThrow(_cursor, "explain");
      final int _cursorIndexOfPoster = CursorUtil.getColumnIndexOrThrow(_cursor, "poster");
      final List<MovieEntry> _result = new ArrayList<MovieEntry>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MovieEntry _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpGenre;
        if (_cursor.isNull(_cursorIndexOfGenre)) {
          _tmpGenre = null;
        } else {
          _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
        }
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final String _tmpExplain;
        if (_cursor.isNull(_cursorIndexOfExplain)) {
          _tmpExplain = null;
        } else {
          _tmpExplain = _cursor.getString(_cursorIndexOfExplain);
        }
        final int _tmpPoster;
        _tmpPoster = _cursor.getInt(_cursorIndexOfPoster);
        _item = new MovieEntry(_tmpId,_tmpName,_tmpGenre,_tmpYear,_tmpExplain,_tmpPoster);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MovieEntry> getRomances() {
    final String _sql = "SELECT * FROM movie WHERE genre = 'عاشقانه'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfExplain = CursorUtil.getColumnIndexOrThrow(_cursor, "explain");
      final int _cursorIndexOfPoster = CursorUtil.getColumnIndexOrThrow(_cursor, "poster");
      final List<MovieEntry> _result = new ArrayList<MovieEntry>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MovieEntry _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpGenre;
        if (_cursor.isNull(_cursorIndexOfGenre)) {
          _tmpGenre = null;
        } else {
          _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
        }
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final String _tmpExplain;
        if (_cursor.isNull(_cursorIndexOfExplain)) {
          _tmpExplain = null;
        } else {
          _tmpExplain = _cursor.getString(_cursorIndexOfExplain);
        }
        final int _tmpPoster;
        _tmpPoster = _cursor.getInt(_cursorIndexOfPoster);
        _item = new MovieEntry(_tmpId,_tmpName,_tmpGenre,_tmpYear,_tmpExplain,_tmpPoster);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MovieEntry> getSciFis() {
    final String _sql = "SELECT * FROM movie WHERE genre = 'علمی تخیلی'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfExplain = CursorUtil.getColumnIndexOrThrow(_cursor, "explain");
      final int _cursorIndexOfPoster = CursorUtil.getColumnIndexOrThrow(_cursor, "poster");
      final List<MovieEntry> _result = new ArrayList<MovieEntry>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MovieEntry _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpGenre;
        if (_cursor.isNull(_cursorIndexOfGenre)) {
          _tmpGenre = null;
        } else {
          _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
        }
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final String _tmpExplain;
        if (_cursor.isNull(_cursorIndexOfExplain)) {
          _tmpExplain = null;
        } else {
          _tmpExplain = _cursor.getString(_cursorIndexOfExplain);
        }
        final int _tmpPoster;
        _tmpPoster = _cursor.getInt(_cursorIndexOfPoster);
        _item = new MovieEntry(_tmpId,_tmpName,_tmpGenre,_tmpYear,_tmpExplain,_tmpPoster);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MovieEntry> getWars() {
    final String _sql = "SELECT * FROM movie WHERE genre = 'جنگی'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfGenre = CursorUtil.getColumnIndexOrThrow(_cursor, "genre");
      final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
      final int _cursorIndexOfExplain = CursorUtil.getColumnIndexOrThrow(_cursor, "explain");
      final int _cursorIndexOfPoster = CursorUtil.getColumnIndexOrThrow(_cursor, "poster");
      final List<MovieEntry> _result = new ArrayList<MovieEntry>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MovieEntry _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        final String _tmpGenre;
        if (_cursor.isNull(_cursorIndexOfGenre)) {
          _tmpGenre = null;
        } else {
          _tmpGenre = _cursor.getString(_cursorIndexOfGenre);
        }
        final int _tmpYear;
        _tmpYear = _cursor.getInt(_cursorIndexOfYear);
        final String _tmpExplain;
        if (_cursor.isNull(_cursorIndexOfExplain)) {
          _tmpExplain = null;
        } else {
          _tmpExplain = _cursor.getString(_cursorIndexOfExplain);
        }
        final int _tmpPoster;
        _tmpPoster = _cursor.getInt(_cursorIndexOfPoster);
        _item = new MovieEntry(_tmpId,_tmpName,_tmpGenre,_tmpYear,_tmpExplain,_tmpPoster);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
