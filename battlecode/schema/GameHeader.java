// automatically generated, do not modify

package battlecode.schema;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
/**
 * The first event sent in the game. Contains all metadata about the game.
 */
public final class GameHeader extends Table {
  public static GameHeader getRootAsGameHeader(ByteBuffer _bb) { return getRootAsGameHeader(_bb, new GameHeader()); }
  public static GameHeader getRootAsGameHeader(ByteBuffer _bb, GameHeader obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public GameHeader __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  /**
   * The version of the spec this game complies with.
   */
  public String specVersion() { int o = __offset(4); return o != 0 ? __string(o + bb_pos) : null; }
  public ByteBuffer specVersionAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  /**
   * The teams participating in the game.
   */
  public TeamData teams(int j) { return teams(new TeamData(), j); }
  public TeamData teams(TeamData obj, int j) { int o = __offset(6); return o != 0 ? obj.__init(__indirect(__vector(o) + j * 4), bb) : null; }
  public int teamsLength() { int o = __offset(6); return o != 0 ? __vector_len(o) : 0; }
  /**
   * Information about all body types in the game.
   */
  public BodyTypeMetadata bodyTypeMetadata(int j) { return bodyTypeMetadata(new BodyTypeMetadata(), j); }
  public BodyTypeMetadata bodyTypeMetadata(BodyTypeMetadata obj, int j) { int o = __offset(8); return o != 0 ? obj.__init(__indirect(__vector(o) + j * 4), bb) : null; }
  public int bodyTypeMetadataLength() { int o = __offset(8); return o != 0 ? __vector_len(o) : 0; }

  public static int createGameHeader(FlatBufferBuilder builder,
      int specVersionOffset,
      int teamsOffset,
      int bodyTypeMetadataOffset) {
    builder.startObject(3);
    GameHeader.addBodyTypeMetadata(builder, bodyTypeMetadataOffset);
    GameHeader.addTeams(builder, teamsOffset);
    GameHeader.addSpecVersion(builder, specVersionOffset);
    return GameHeader.endGameHeader(builder);
  }

  public static void startGameHeader(FlatBufferBuilder builder) { builder.startObject(3); }
  public static void addSpecVersion(FlatBufferBuilder builder, int specVersionOffset) { builder.addOffset(0, specVersionOffset, 0); }
  public static void addTeams(FlatBufferBuilder builder, int teamsOffset) { builder.addOffset(1, teamsOffset, 0); }
  public static int createTeamsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startTeamsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addBodyTypeMetadata(FlatBufferBuilder builder, int bodyTypeMetadataOffset) { builder.addOffset(2, bodyTypeMetadataOffset, 0); }
  public static int createBodyTypeMetadataVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startBodyTypeMetadataVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static int endGameHeader(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
};

