@Override
public void register(RegisterRequest request) {

    if (userRepository.existsByEmail(request.getEmail())) {
        throw new IllegalArgumentException("Email already exists");
    }

    Role role = roleRepository.findByName(request.getRoleName())
            .orElseThrow(() -> new IllegalArgumentException("Role not found"));

    AppUser user = new AppUser();
    user.setFullName(request.getFullName());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setEnabled(true);
    user.setRoles(Set.of(role));
    user.setCreatedAt(LocalDateTime.now());

    userRepository.save(user);
}
