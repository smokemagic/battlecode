// automatically generated, do not modify

package battlecode.schema;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
/**
 * Metadata about all bodies of a particular type.
 */
public final class BodyTypeMetadata extends Table {
  public static BodyTypeMetadata getRootAsBodyTypeMetadata(ByteBuffer _bb) { return getRootAsBodyTypeMetadata(_bb, new BodyTypeMetadata()); }
  public static BodyTypeMetadata getRootAsBodyTypeMetadata(ByteBuffer _bb, BodyTypeMetadata obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public BodyTypeMetadata __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  /**
   * The relevant type.
   */
  public byte type() { int o = __offset(4); return o != 0 ? bb.get(o + bb_pos) : 0; }
  /**
   * The radius of the type, in distance units.
   */
  public float radius() { int o = __offset(6); return o != 0 ? bb.getFloat(o + bb_pos) : 0; }
  /**
   * The cost of the type, in bullets.
   */
  public float cost() { int o = __offset(8); return o != 0 ? bb.getFloat(o + bb_pos) : 0; }
  /**
   * The maxiumum health of the type, in health units.
   */
  public float maxHealth() { int o = __offset(10); return o != 0 ? bb.getFloat(o + bb_pos) : 0; }
  /**
   * If unset, the same as maxHealth.
   * Otherwise, the health a body of this type starts with.
   */
  public float startHealth() { int o = __offset(12); return o != 0 ? bb.getFloat(o + bb_pos) : 0; }
  /**
   * The delay penalty added to the core counter after movement.
   */
  public float moveDelay() { int o = __offset(14); return o != 0 ? bb.getFloat(o + bb_pos) : 0; }
  /**
   * The delay penalty added to the attack counter after movement.
   */
  public float attackDelay() { int o = __offset(16); return o != 0 ? bb.getFloat(o + bb_pos) : 0; }
  /**
   * The delay penalty added to the attack counter after movement, and vice versa.
   */
  public float cooldownDelay() { int o = __offset(18); return o != 0 ? bb.getFloat(o + bb_pos) : 0; }
  /**
   * The speed that bullets from this unit move.
   * Note: you don't need to keep track of this, SpawnedBody.vel will always be set.
   */
  public float bulletSpeed() { int o = __offset(20); return o != 0 ? bb.getFloat(o + bb_pos) : 0; }
  /**
   * The damage that bullets from this unit inflict.
   * Note: you don't need to keep track of this.
   */
  public float bulletAttack() { int o = __offset(22); return o != 0 ? bb.getFloat(o + bb_pos) : 0; }

  public static int createBodyTypeMetadata(FlatBufferBuilder builder,
      byte type,
      float radius,
      float cost,
      float maxHealth,
      float startHealth,
      float moveDelay,
      float attackDelay,
      float cooldownDelay,
      float bulletSpeed,
      float bulletAttack) {
    builder.startObject(10);
    BodyTypeMetadata.addBulletAttack(builder, bulletAttack);
    BodyTypeMetadata.addBulletSpeed(builder, bulletSpeed);
    BodyTypeMetadata.addCooldownDelay(builder, cooldownDelay);
    BodyTypeMetadata.addAttackDelay(builder, attackDelay);
    BodyTypeMetadata.addMoveDelay(builder, moveDelay);
    BodyTypeMetadata.addStartHealth(builder, startHealth);
    BodyTypeMetadata.addMaxHealth(builder, maxHealth);
    BodyTypeMetadata.addCost(builder, cost);
    BodyTypeMetadata.addRadius(builder, radius);
    BodyTypeMetadata.addType(builder, type);
    return BodyTypeMetadata.endBodyTypeMetadata(builder);
  }

  public static void startBodyTypeMetadata(FlatBufferBuilder builder) { builder.startObject(10); }
  public static void addType(FlatBufferBuilder builder, byte type) { builder.addByte(0, type, 0); }
  public static void addRadius(FlatBufferBuilder builder, float radius) { builder.addFloat(1, radius, 0); }
  public static void addCost(FlatBufferBuilder builder, float cost) { builder.addFloat(2, cost, 0); }
  public static void addMaxHealth(FlatBufferBuilder builder, float maxHealth) { builder.addFloat(3, maxHealth, 0); }
  public static void addStartHealth(FlatBufferBuilder builder, float startHealth) { builder.addFloat(4, startHealth, 0); }
  public static void addMoveDelay(FlatBufferBuilder builder, float moveDelay) { builder.addFloat(5, moveDelay, 0); }
  public static void addAttackDelay(FlatBufferBuilder builder, float attackDelay) { builder.addFloat(6, attackDelay, 0); }
  public static void addCooldownDelay(FlatBufferBuilder builder, float cooldownDelay) { builder.addFloat(7, cooldownDelay, 0); }
  public static void addBulletSpeed(FlatBufferBuilder builder, float bulletSpeed) { builder.addFloat(8, bulletSpeed, 0); }
  public static void addBulletAttack(FlatBufferBuilder builder, float bulletAttack) { builder.addFloat(9, bulletAttack, 0); }
  public static int endBodyTypeMetadata(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
};

